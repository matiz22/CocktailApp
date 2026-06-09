package pl.matiz22.cocktails.data.local.services

import kotlinx.cinterop.ExperimentalForeignApi
import pl.matiz22.cocktails.domain.services.DailyDrinkSchedulingService
import platform.BackgroundTasks.BGAppRefreshTaskRequest
import platform.BackgroundTasks.BGTaskScheduler
import platform.Foundation.NSCalendar
import platform.Foundation.NSComparisonResult
import platform.Foundation.NSDate
import platform.Foundation.NSUserDefaults
import platform.Foundation.compare
import platform.Foundation.dateByAddingTimeInterval

actual class DailyDrinkSchedulingServiceImpl : DailyDrinkSchedulingService {
    @OptIn(ExperimentalForeignApi::class)
    override fun scheduleNotification(hour: Int, minute: Int): Boolean {
        NSUserDefaults.standardUserDefaults.setInteger(hour.toLong(), REMINDER_HOUR_KEY)
        NSUserDefaults.standardUserDefaults.setInteger(minute.toLong(), REMINDER_MINUTES_KEY)

        val request = BGAppRefreshTaskRequest(identifier = BACKGROUND_TASK_ID)
        val calendar = NSCalendar.currentCalendar
        val now = NSDate()
        var targetDate = calendar.startOfDayForDate(now)
            .dateByAddingTimeInterval((hour * 3600 + minute * 60).toDouble())
        if (targetDate.compare(now) != NSComparisonResult.MAX_VALUE) {
            targetDate = targetDate.dateByAddingTimeInterval((24 * 3600).toDouble())
        }
        request.earliestBeginDate = targetDate
        return BGTaskScheduler.sharedScheduler.submitTaskRequest(request, null)
    }

    override fun unScheduleNotification(): Boolean {
        NSUserDefaults.standardUserDefaults.removeObjectForKey(REMINDER_HOUR_KEY)
        NSUserDefaults.standardUserDefaults.removeObjectForKey(REMINDER_MINUTES_KEY)
        BGTaskScheduler.sharedScheduler.cancelTaskRequestWithIdentifier(BACKGROUND_TASK_ID)
        return true
    }

    companion object {
        private const val BACKGROUND_TASK_ID = "pl.matiz22.cocktailapp.scheduler"
        private const val REMINDER_HOUR_KEY = "reminderHourKey"
        private const val REMINDER_MINUTES_KEY = "reminderMinuteKey"
    }
}
