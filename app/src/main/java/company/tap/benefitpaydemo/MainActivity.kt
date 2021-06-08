package company.tap.benefitpaydemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import mobi.foo.benefitinapp.data.Transaction
import mobi.foo.benefitinapp.listener.BenefitInAppButtonListener
import mobi.foo.benefitinapp.listener.CheckoutListener
import mobi.foo.benefitinapp.utils.BenefitInAppCheckout
import mobi.foo.benefitinapp.utils.BenefitInAppHelper

class MainActivity : AppCompatActivity() ,CheckoutListener,BenefitInAppButtonListener {
    val appId:String="4530082749"
    val merchantId:String="00000101"
    val seceret:String="3l5e0cstdim11skgwoha8x9vx9zo0kxxi4droryjp4eqd"
    val countrycode:String="1001"
    val mcc:String="4816"
     private val context: Context?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.context
        checkout_btn.setListener(this)


     /*  checkout_btn.setListener(object : BenefitInAppButtonListener {
           override fun onButtonClicked() {
               BenefitInAppCheckout.newInstance(
                   this@MainActivity,
                   appId,
                   "445544",
                   merchantId,
                   seceret,
                   "20.0",
                   "BH",
                   "048",
                   mcc,
                   "Tap",
                   "Manama",
                   this@MainActivity)
                println("values set in benefit checckout are ${"app val : "+ appId +"merchant id :"+ merchantId +"sceret : " + seceret+"countrycode are :"+ countrycode +"mcc val : "+mcc } ")
           }

           override fun onFail(p0: Int) {
               println("failed is value is  ${p0}")
           }


       })*/

    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)
        if (resultCode == RESULT_OK) {
            BenefitInAppHelper.handleResult(data);
        }

    }

    override fun onTransactionSuccess(p0: Transaction?) {
        println("transaction is success $p0")
        Toast.makeText(this, p0?.transactionMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onTransactionFail(p0: Transaction?) {
        println("onTransactionFail is  $p0")
    }

    override fun onButtonClicked() {
        BenefitInAppCheckout.newInstance(
            this@MainActivity,
            appId,
            "445544",
            merchantId,
            seceret,
            "20.0",
            "BH",
            "048",
            mcc,
            "Tap",
            "Manama",
            this@MainActivity)
        println("values set in benefit checckout are ${"app val : "+ appId +"merchant id :"+ merchantId +"sceret : " + seceret+"countrycode are :"+ countrycode +"mcc val : "+mcc } ")
    }

    override fun onFail(p0: Int) {
        println("failed is value is  ${p0}")
    }

}

