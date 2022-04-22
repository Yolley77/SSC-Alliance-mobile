package ru.sscalliance.data.team.local

import ru.sscalliance.data.base.BaseCacheDataSource
import ru.sscalliance.data.base.BaseCloudDataSource
import ru.sscalliance.data.network.ApiHelper
import ru.sscalliance.data.team.local.model.TeamStorageModel
import ru.sscalliance.domain.team.model.TeamBusinessModel
import javax.inject.Inject

interface ITeamLocalDataSource {
    fun save(teams: List<TeamBusinessModel>)
    fun get(): List<TeamBusinessModel>
}
class TeamLocalDataSource @Inject constructor(
    val api: ApiHelper
): ITeamLocalDataSource, BaseCacheDataSource<TeamStorageModel>(TeamStorageModel::class.java){
    override fun save(teams: List<TeamBusinessModel>) {
        TODO("Not yet implemented")
    }

    override fun get(): List<TeamBusinessModel> {
        TODO("Not yet implemented")
    }
}