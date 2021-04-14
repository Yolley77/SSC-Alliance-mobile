package ru.sscalliance.domain.section.model

import androidx.annotation.StringRes
import ru.sscalliance.R

enum class SectionType(@StringRes val titleRes: Int) {

    FOOTBALL(R.string.section_football),
    VOLLEYBALL(R.string.section_volleyball),
    BASKETBALL(R.string.section_basketball),
    CHESS(R.string.section_chess),
    PING_PONG(R.string.section_ping_pong),
    BADMINTON(R.string.section_badminton),

}