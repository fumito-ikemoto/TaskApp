package jp.techacademy.fumito.ikemoto.taskapp

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

open class Category : RealmObject(), Serializable {
    var name : String = "" //カテゴリー名

    @PrimaryKey
    var categoryId : Int = 0 //ユニークID
}