package pl.matiz22.cocktails.domain.services

interface DrinksNotificationService {
    suspend fun showRandomDrinkNotification(): Boolean
}
