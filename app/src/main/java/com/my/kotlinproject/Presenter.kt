package com.my.kotlinproject

// instantiating the objects of View and Model Interface
// creating object of View Interface
// creating object of Model Interface
data class Presenter(
    private var mainView: Contract.View?,
    private val model: Contract.Model) : Contract.Presenter,
    Contract.Model.OnFinishedListener {

    // operations to be performed
    // on button click
    override fun onButtonClick()  {
        mainView?.showProgress()
        model.getNextCourse(this)
    }

    override fun onDestroy() {
        mainView = null
    }

    // method to return the string
    // which will be displayed in the
    // Course Detail TextView
    override fun onFinished(string: String?) {
        mainView?.setString(string)
        mainView?.hideProgress()
    }

}
