package com.my.kotlinproject

import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.TextView
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.ArgumentMatchers.any
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class PresenterTest {

    @Mock
    lateinit var model: Contract.Model

    @Mock
    lateinit var view: Contract.View

    lateinit var presenter: Presenter

    @Captor
    var captor: ArgumentCaptor<String> = ArgumentCaptor.forClass(null)


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        presenter = Presenter(view, model)
    }

    @Test
    fun `test getNextCourse`() {
        // given
        Mockito.`when`(model.getNextCourse(any())).then {
            view.setString("test")
        }

        // when
        presenter.onButtonClick()

        // then
        Mockito.verify(view).setString(captor.capture())
        val test=captor.value
        Assert.assertEquals("test",test)
//        Assert.assertEquals("tes",test)
    }
}