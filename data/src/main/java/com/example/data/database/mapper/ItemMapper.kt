package com.example.data.database.mapper

import com.example.data.database.ItemEntity
import com.example.domain.model.Item

class ItemMapper : Mapper<ItemEntity, Item> {

    override fun mapFromEntity(type: ItemEntity): Item {
        with(type) {
            return Item(
                id = id,
                image = image,
                isObtained = isObtained
            )
        }
    }

    override fun mapToEntity(type: Item): ItemEntity {
        with(type) {
            return ItemEntity(
                id = id,
                image = image,
                isObtained = isObtained
            )
        }
    }

}