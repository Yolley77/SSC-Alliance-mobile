package ru.sscalliance.utils

import android.content.Context
import ru.sscalliance.domain.section.model.SectionType

object SectionUtils {

    fun getSectionPositionByType(type: SectionType): Int {
        val item = SectionType.values().find { it.name == type.name }
        return item?.ordinal ?: 0
    }

    fun getSectionLogoByType(type: SectionType): String {
        return ""
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
        val item = SectionType.values()[position]
        return context.getString(item.titleRes)
    }

}