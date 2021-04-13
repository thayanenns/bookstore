import { Book } from './book/Book';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from './book/book-service.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BookStore';
  books: Book[] = [];

  constructor(private router: Router, private bookService: BookService){}

  getBooks(){
    this.bookService.getBooks().subscribe(data => {
      this.books = data;
    });
  }

  addBook(): void {
    this.router.navigate(['add-book']).then((e) => {
      if(e){
        console.log("Navigation is sucessful");
      } else{
      console.log("Navigation has failed");
      }
    });
  };

  ngOnInit(): void{
    this.router.events.subscribe(value => {
      this.getBooks();
    });
  }
}
