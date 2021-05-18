package ru.sscalliance.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import ru.sscalliance.R
import ru.sscalliance.domain.sport.sectionScreen.model.SectionType

object SectionUtils {

    fun getSectionsArray() = SectionType.values()

    fun getSectionPositionByType(type: SectionType): Int {
        val item = getSectionsArray().find { it.name == type.name }
        return item?.ordinal ?: 0
    }

    fun getSectionLogoByType(type: SectionType, context: Context?): Drawable? =
        context?.let {
            when (type) {
                SectionType.FOOTBALL -> ContextCompat.getDrawable(it, R.drawable.ic_football)
                SectionType.VOLLEYBALL -> ContextCompat.getDrawable(it, R.drawable.ic_volleyball)
                SectionType.BASKETBALL -> ContextCompat.getDrawable(it, R.drawable.ic_basketball)
                SectionType.CHESS -> ContextCompat.getDrawable(it, R.drawable.ic_checkmate)
                SectionType.PING_PONG -> ContextCompat.getDrawable(it, R.drawable.ic_ping_pong)
                SectionType.BADMINTON -> ContextCompat.getDrawable(it, R.drawable.ic_badminton)
            }
        }

    fun getSectionRequestByType(type: SectionType): String {
        return when (type) {
            SectionType.FOOTBALL -> AppConstants.FOOTBALL_REQUEST
            SectionType.VOLLEYBALL -> AppConstants.VOLLEYBALL_REQUEST
            SectionType.BASKETBALL -> AppConstants.BASKETBALL_REQUEST
            SectionType.CHESS -> AppConstants.CHESS_REQUEST
            SectionType.PING_PONG -> AppConstants.PING_PONG_REQUEST
            SectionType.BADMINTON -> AppConstants.BADMINTON_REQUEST
        }
    }

    fun getSectionNameByPosition(position: Int, context: Context): String {
        val item = getSectionsArray()[position]
        return context.getString(item.titleRes)
    }

}