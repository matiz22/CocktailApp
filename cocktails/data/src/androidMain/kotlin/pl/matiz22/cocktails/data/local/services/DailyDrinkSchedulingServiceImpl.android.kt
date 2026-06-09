// package pl.matiz22.cocktails.data.local.services
//
// import android.app.AlarmManager
// import android.app.PendingIntent
// import android.content.Context
// import android.content.Intent
// import android.icu.util.Calendar
//
// import pl.matiz22.cocktails.domain.services.DailyDrinkSchedulingService
//
// actual class DailyDrinkSchedulingServiceImpl(
//    private val context: Context,
// ) : DailyDrinkSchedulingService {
//    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//    val prefs = context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
//
//    override fun scheduleNotification(hour: Int, minute: Int): Boolean {
//        with(prefs.edit()) {
//            putInt(REMINDER_HOUR_KEY, hour)
//            putInt(REMINDER_MINUTES_KEY, minute)
//            apply()
//        }
//
//        val pendingIntent = Intent(context, DailyDrinkAlarmReceiver::class.java).let { intent ->
//            PendingIntent.getBroadcast(
//                context,
//                REQUEST_CODE_ALARM,
//                intent,
//                PendingIntent.FLAG_IMMUTABLE,
//            )
//        }
//
//        val now = Calendar.getInstance()
//        val scheduledTime = Calendar.getInstance().apply {
//            set(Calendar.HOUR_OF_DAY, hour)
//            set(Calendar.MINUTE, minute)
//            set(Calendar.SECOND, 0)
//            set(Calendar.MILLISECOND, 0)
//        }
//
//        if (scheduledTime.before(now)) {
//            scheduledTime.add(Calendar.DAY_OF_MONTH, 1)
//        }
//
//        alarmManager.setExactAndAllowWhileIdle(
//            AlarmManager.RTC_WAKEUP,
//            scheduledTime.timeInMillis,
//            pendingIntent,
//        )
//        return true
//    }
//
//    override fun unScheduleNotification(): Boolean {
//        with(prefs.edit()) {
//            remove(REMINDER_HOUR_KEY)
//            remove(REMINDER_MINUTES_KEY)
//            apply()
//        }
//        alarmManager.cancel(
//            PendingIntent.getBroadcast(
//                context,
//                REQUEST_CODE_ALARM,
//                Intent(context, AlarmManager::class.java),
//                PendingIntent.FLAG_IMMUTABLE,
//            ),
//        )
//        return true
//    }
//
//    companion object {
//        const val PREF_KEY = "dailyPrefs"
//        const val REQUEST_CODE_ALARM = 1
//        const val REMINDER_HOUR_KEY = "reminderHourKey"
//        const val REMINDER_MINUTES_KEY = "reminderMinuteKey"
//    }
// }
