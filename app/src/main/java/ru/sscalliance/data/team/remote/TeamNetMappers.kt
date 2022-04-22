package ru.sscalliance.data.team.remote

import ru.sscalliance.data.common.Mapper
import ru.sscalliance.data.team.remote.model.TeamResponse
import ru.sscalliance.domain.team.model.TeamBusinessModel

object TeamNetToUIMapper: Mapper<TeamResponse, TeamBusinessModel> {
    override fun map(from: TeamResponse): TeamBusinessModel = TeamBusinessModel().apply {
        id = from.id
        logo = from.logo
        title = from.title
        history = from.history
        trainingAddress = from.trainingAddress
      //  trainingSchedule = from.trainingSchedule
       // trainingGallery = from.trainingGallery
    }
}