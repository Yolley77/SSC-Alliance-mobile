package ru.sscalliance.data.team.local

import ru.sscalliance.data.common.Mapper
import ru.sscalliance.data.team.local.model.TeamStorageModel
import ru.sscalliance.domain.team.model.TeamBusinessModel

object TeamUIToStorageMapper: Mapper<TeamBusinessModel, TeamStorageModel> {
    override fun map(from: TeamBusinessModel): TeamStorageModel = TeamStorageModel().apply {
        id = from.id
        title = from.title
        logo = from.logo
        //trainingGallery = from.trainingGallery
        //trainingSchedule = from.trainingSchedule
        trainingAddress = from.trainingAddress
        history = from.history
    }
}
object TeamStorageToUIMapper: Mapper<TeamStorageModel, TeamBusinessModel> {
    override fun map(from: TeamStorageModel): TeamBusinessModel = TeamBusinessModel().apply {
        id = from.id
        title = from.title
        logo = from.logo
        //trainingGallery = from.trainingGallery
        //trainingSchedule = from.trainingSchedule
        trainingAddress = from.trainingAddress
        history = from.history
    }
}
