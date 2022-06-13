package com.example.ultimatebodyworkout

object Constants {

    fun defaultExerciseList(): ArrayList<ExerciseModel>{
         val exerciseList = ArrayList<ExerciseModel>()
         val jumpingJacks = ExerciseModel(
             1,
             "Jumping Jacks",
             R.drawable.jumping_jacks,
             false,
             false
         )
        exerciseList.add(jumpingJacks)

        val pushUp = ExerciseModel(
            2,
            "Push Ups",
            R.drawable.push_ups,
            false,
            false
        )
        exerciseList.add(pushUp)

        val squats = ExerciseModel(
            3,
            "Squats",
            R.drawable.squats,
            false,
            false
        )
        exerciseList.add(squats)

        return exerciseList
    }
}