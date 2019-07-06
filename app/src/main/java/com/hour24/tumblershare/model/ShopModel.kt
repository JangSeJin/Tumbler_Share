package com.hour24.tumblershare.model

/**
 * @author jess
 * @since 2019-06-07
 */

/**
 * 매장 정보
{
"name": "스타벅스",
"supplier_id": 1,
"branch": "이태원점",
"address": "서울특별시 용산구 이태원로 188",
"zipcode": "140200",
"phone": "02-567-5678",
"latitude": "37.53430294",
"longitude": "126.9947813"
}
 */
data class ShopModel constructor(
    var name: String,
    var supplier_id: Int,
    var branch: String,
    var address: String,
    var zipcode: String,
    var phone: String,
    var latitude: String,
    var longitude: String,
    var distance: Double
)
