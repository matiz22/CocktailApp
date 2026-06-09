package pl.matiz22.cocktails.domain.services

interface DailyDrinkSchedulingService {
    fun scheduleNotification(hour: Int, minute: Int): Boolean
    fun unScheduleNotification(): Boolean
}
