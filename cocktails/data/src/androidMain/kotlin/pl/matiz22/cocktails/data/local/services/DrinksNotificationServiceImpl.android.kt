package pl.matiz22.cocktails.data.local.services

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.net.toUri
import pl.matiz22.cocktails.data.R
import pl.matiz22.cocktails.domain.repository.remote.DrinksRepository
import pl.matiz22.cocktails.domain.service.util.NotificationConstants
import pl.matiz22.cocktails.domain.services.DrinksNotificationService

actual class DrinksNotificationServiceImpl(
    private val context: Context,
    private val drinksRepository: DrinksRepository,
    private val intentActivity: Class<*>,
) : DrinksNotificationService {
    override suspend fun showRandomDrinkNotification(): Boolean {
        val drink = drinksRepository.getRandomDrink().data ?: return false
        val intent = Intent(
            Intent.ACTION_VIEW,
            "cocktail_app://cocktails/drink/${drink.id}".toUri(),
            context,
            intentActivity,
        )

        val pendingIntent = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_IMMUTABLE)
        }
        val notification =
            NotificationCompat.Builder(context, NotificationConstants.RANDOM_DRINK_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle(drink.name)
                .setSubText(drink.category)
                .setContentText(drink.instructions)
                .setContentIntent(pendingIntent)
                .build()

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notification)
        return true
    }
}
