package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //calling appendExpressionFunction from here

        binding.tvone.setOnClickListener { appendExpression("1",true) }
        binding.tvtwo.setOnClickListener { appendExpression("2",true) }
        binding.tvthree.setOnClickListener { appendExpression("3",true) }
        binding.tvfour.setOnClickListener { appendExpression("4",true) }
        binding.tvfive.setOnClickListener { appendExpression("5",true) }
        binding.tvsix.setOnClickListener { appendExpression("6",true) }
        binding.tvseven.setOnClickListener { appendExpression("7",true) }
        binding.tveight.setOnClickListener { appendExpression("8",true) }
        binding.tvnine.setOnClickListener { appendExpression("9",true) }
        binding.tvdot.setOnClickListener { appendExpression(".",true) }


        binding.tvplus.setOnClickListener { appendExpression("+",false) }
        binding.tvminus.setOnClickListener { appendExpression("-",false) }
        binding.tvmul.setOnClickListener { appendExpression("*",false) }
        binding.tvdivide.setOnClickListener { appendExpression("/",false) }
        binding.tvopenbracket.setOnClickListener { appendExpression("(",false) }
        binding.tvclosebracket.setOnClickListener { appendExpression(")",false) }


        binding.tvclear.setOnClickListener {
            binding.tvresult.text="";
            binding.tvexpression.text="";
        }

        binding.tvback.setOnClickListener {
            val string=binding.tvexpression.text.toString()
            if(string.isNotEmpty())
            {
                binding.tvexpression.text=string.substring(0,string.length-1)
            }
            binding.tvresult.text=""
        }

        binding.tvequal.setOnClickListener {
            try{

                    val expression=ExpressionBuilder(binding.tvexpression.text.toString()).build()
                    val result=expression.evaluate()
                    val longres=result.toLong()
                if(result==longres.toDouble())
                {
                    binding.tvresult.text=longres.toString()
                }else{

                    binding.tvresult.text=result.toString()
                }
            }
            catch (e:Exception)
            {
                    Toast.makeText(this,"error occured"+{e.message},Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun appendExpression( string: String, canclear:Boolean)
    {
        if(binding.tvresult.text.isNotEmpty())
        {
            binding.tvexpression.text=""
        }
        if(canclear==true)
        {
            binding.tvresult.text=""
            binding.tvexpression.append(string)
        }
        else{
            binding.tvexpression.append(binding.tvresult.text)
            binding.tvexpression.append(string)
            binding.tvresult.text=""

        }
    }
}