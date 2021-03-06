package com.example.ultimatebodyworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.ultimatebodyworkout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private lateinit var binding : ActivityExerciseBinding

    private var restTimer: CountDownTimer? = null
    private  var restProgress = 0

    private var exerciseTimer: CountDownTimer? = null
    private  var exerciseProgress = 0


    private var exerciseList: ArrayList<ExerciseModel>? = null
    private var currentExercisePosition = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbarExercise)
        if(supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        exerciseList = Constants.defaultExerciseList()

        binding.toolbarExercise?.setNavigationOnClickListener{
            onBackPressed()
        }
        setRestView()
    }

    private fun setRestView(){
        binding.flRestView.visibility= View.VISIBLE
        binding.tvTitle.visibility = View.VISIBLE
        binding?.tvExerciseName?.visibility = View.INVISIBLE
        binding.flExerciseView.visibility = View.INVISIBLE
        binding.ivImage.visibility = View.INVISIBLE


        if(restTimer!=null){
            restTimer?.cancel()
            restProgress=0
        }
        setRestProgressBar()
    }

    private fun setupExerciseView(){
        binding.flRestView.visibility= View.INVISIBLE
        binding.tvTitle.visibility = View.INVISIBLE
        binding?.tvExerciseName?.visibility = View.VISIBLE
        binding.flExerciseView.visibility = View.VISIBLE
        binding.ivImage.visibility = View.VISIBLE

        if(exerciseTimer!=null){
            exerciseTimer?.cancel()
            exerciseProgress=0
        }

        binding?.ivImage?.setImageResource(exerciseList!![currentExercisePosition].getImage())
        binding?.tvExerciseName?.text = exerciseList!![currentExercisePosition].getName()

        setExerciseProgressBar()
    }

    private fun setRestProgressBar(){
        binding.progressBar.progress = restProgress

        restTimer = object : CountDownTimer(10000,1000 ){
            override fun onTick(p0: Long) {
                restProgress++
                binding.progressBar.progress=10-restProgress
                binding.tvTimer.text = (10-restProgress).toString()
            }

            override fun onFinish() {
                currentExercisePosition++
                setupExerciseView()
                Toast.makeText(this@ExerciseActivity,"Here now we will start the exercise.",Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    private fun setExerciseProgressBar(){
        binding.progressBarExercise.progress = exerciseProgress

        exerciseTimer = object : CountDownTimer(30000,1000 ){
            override fun onTick(p0: Long) {
                exerciseProgress++
                binding.progressBarExercise.progress=30-exerciseProgress
                binding.tvTimerExercise.text = (30-exerciseProgress).toString()
            }

            override fun onFinish() {
                if(currentExercisePosition<exerciseList?.size!!-1) {
                    setRestView()
                }
                else {
                    Toast.makeText(
                        this@ExerciseActivity,
                        "Congratulations!! Exercise Completed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()

        if(restTimer!=null){
            restTimer?.cancel()
            restProgress=0
        }
    }

}