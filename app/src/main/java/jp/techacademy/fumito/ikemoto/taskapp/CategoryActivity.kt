package jp.techacademy.fumito.ikemoto.taskapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        decisionButton.setOnClickListener{view ->
            if(idEditText.text.isEmpty())
            {
                Snackbar.make(view, "IDを入力してください", Snackbar.LENGTH_SHORT)
                    .show()

                return@setOnClickListener
            }

            if(categoryNameEditText.text.isEmpty()){
                Snackbar.make(view, "カテゴリーを入力してください", Snackbar.LENGTH_SHORT)
                    .show()

                return@setOnClickListener
            }

            val realm = Realm.getDefaultInstance()
            val categoryID = idEditText.text.toString().toInt()
            val categoryName = categoryNameEditText.text.toString()
            val category = Category()
            category.categoryId = categoryID
            category.name = categoryName

            realm.beginTransaction()
            realm.copyToRealmOrUpdate(category)
            realm.commitTransaction()
            realm.close()

            Snackbar.make(view, "カテゴリー設定完了", Snackbar.LENGTH_SHORT).show()
        }


    }
}
