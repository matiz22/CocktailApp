package pl.matiz22.cocktails.data.local.services

import pl.matiz22.cocktails.domain.repository.remote.DrinksRepository
import pl.matiz22.cocktails.domain.services.DrinksNotificationService
import platform.UserNotifications.UNMutableNotificationContent
import platform.UserNotifications.UNNotificationRequest
import platform.UserNotifications.UNUserNotificationCenter

actual class DrinksNotificationServiceImpl(private val drinksRepository: DrinksRepository) : DrinksNotificationService {
    override suspend fun showRandomDrinkNotification(): Boolean {
        val drink = drinksRepository.getRandomDrink().data ?: return false
        val notificationContent = UNMutableNotificationContent()
        notificationContent.setTitle(drink.name)
        notificationContent.setSubtitle(drink.category)
        notificationContent.setBody(drink.instructions)
        val notificationRequest = UNNotificationRequest.requestWithIdentifier(
            identifier = "dailyRandomDrink",
            content = notificationContent,
            trigger = null,
        )
        UNUserNotificationCenter.currentNotificationCenter()
            .addNotificationRequest(request = notificationRequest, withCompletionHandler = null)
        return true
    }
}
