package com.example.clean_architecture.framework.datasource.cache.util

import com.example.clean_architecture.business.domain.model.Note
import com.example.clean_architecture.business.domain.util.DateUtil
import com.example.clean_architecture.business.domain.util.EntityMapper
import com.example.clean_architecture.framework.datasource.cache.model.NoteCacheEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CacheMapper @Inject constructor():EntityMapper<NoteCacheEntity, Note>
{
    fun entityListToNoteList(entities:List<NoteCacheEntity>):List<Note>
    {
        val list:ArrayList<Note> = ArrayList()
        for (entity in entities)
        {
            list.add(mapFromEntity(entity))
        }
        return list
    }
    fun noteListToEntityList(notes:List<Note>):List<NoteCacheEntity>
    {
        val list:ArrayList<NoteCacheEntity> = ArrayList()
        for (note in notes)
        {
            list.add(mapToEntity(note))
        }
        return list
    }
    override fun mapFromEntity(entity: NoteCacheEntity): Note {
        return Note(
            id=entity.id,
            title = entity.title,
            body = entity.body,
            created_at = entity.created_at,
            updated_at = entity.updated_at
        )
    }

    override fun mapToEntity(domainModel: Note): NoteCacheEntity {
        return NoteCacheEntity(
            id=domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            created_at = domainModel.created_at,
            updated_at = domainModel.updated_at
        )
    }

}