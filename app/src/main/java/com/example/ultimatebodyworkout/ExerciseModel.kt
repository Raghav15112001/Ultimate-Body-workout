package com.example.ultimatebodyworkout

class ExerciseModel (
    private var id: Int,
    private var name: String,
    private var image: Int,
    private var isCompleted: Boolean = false,
    private var isSelected: Boolean = false,
){
    fun getId(): Int{
        return id
    }

    fun setId(id:Int){
        this.id=id
    }

    fun getName(): String{
        return name
    }

    fun setName(Name:String){
        this.name=name
    }

    fun getImage(): Int{
        return image
    }

    fun setImage(image:Int){
        this.image=image
    }

    fun getisCompleted(): Boolean{
        return isCompleted
    }

    fun setisCompleted(isCompleted: Boolean){
        this.isCompleted=isCompleted
    }

    fun getisSelected(): Boolean{
        return isSelected
    }

    fun setisSelected(isSelected: Boolean){
        this.isSelected=isSelected
    }

}