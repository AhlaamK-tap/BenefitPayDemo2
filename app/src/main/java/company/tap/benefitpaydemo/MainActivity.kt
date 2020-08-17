package company.tap.benefitpaydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import mobi.foo.benefitinapp.data.Transaction
import mobi.foo.benefitinapp.listener.CheckoutListener
import mobi.foo.benefitinapp.utils.BenefitInAppCheckout
import mobi.foo.benefitinapp.utils.BenefitInAppHelper

class MainActivity : AppCompatActivity(), CheckoutListener {
    val appId:String="4530082749"
    val merchantId:String="00000101"
    val seceret:String="3l5e0cstdim11skgwoha8x9vx9zo0kxxi4droryjp4eqd"
    val currency:String="1001"
    val mcc:String="4816"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun benefitClicked(view: View) {
        BenefitInAppCheckout.newInstance(this,appId,null,merchantId,seceret,null,null,currency,mcc,null,null,this)
    }

    override fun onTransactionFail(p0: Transaction?) {
       println("transaction is failed $p0")
    }

    override fun onTransactionSuccess(p0: Transaction?) {
        println("transaction is success $p0")
    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)
        if (resultCode == RESULT_OK) {
            BenefitInAppHelper.handleResult(data);
        }

    }

}
