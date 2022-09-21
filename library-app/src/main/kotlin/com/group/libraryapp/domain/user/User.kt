package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.user.userLoanHistory.UserLoanHistory
import javax.persistence.*

class User (
    var name: String,

    val age: Int?,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val userLoanHistories: MutableList<UserLoanHistory> = mutableListOf(),

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
){

    init {
        if(name.isBlank()) {
            throw IllegalArgumentException("이름은 비어있을 수 없습니다.")
        }
    }

    fun updateName(name: String) {
        this.name = name;
    }

    fun loanBook(book: Book) {
        this.userLoanHistories.add(UserLoanHistory(this, book.name, false))
    }

    fun returnBook(bookName: String) {
        // first : 코틀린 컬렉션에서 지원, predicate 람다 넣으면 그중 참인 첫번째 값 반
        this.userLoanHistories.first { history -> history.bookName == bookName }.doReturn()
    }
}