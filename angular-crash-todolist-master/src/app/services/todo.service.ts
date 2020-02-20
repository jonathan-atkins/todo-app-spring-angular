import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Todo } from '../models/Todo';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  todosUrl:string = 'http://localhost:8080/';   ;
  todosLimit = '?_limit=5';

  constructor(private http:HttpClient) { }

  // Get Todos
  getTodos():Observable<Todo[]> {
    return this.http.get<Todo[]>(this.todosUrl+'listTodos');
  }

  // Delete Todo
  deleteTodo(todo:Todo):Observable<Todo> {
    //const url = `${this.todosUrl}/${todo.id}`;
    //return this.http.delete<Todo>(url, httpOptions);
    return this.http.post<Todo>(this.todosUrl+'deleteTodo', todo);
  }

  // Add Todo
  addTodo(todo:Todo):Observable<Todo> {
    return this.http.post<Todo>(this.todosUrl+'addTodo', todo, httpOptions);
  }

  // Edit existing todo
  editTodo(todo:Todo):Observable<Todo> {
    return this.http.put<Todo>(this.todosUrl+'editTodo', todo, httpOptions);
  }

  // Toggle Completed
  toggleCompleted(todo: Todo):Observable<any> {
    const url = `${this.todosUrl}/${todo.id}`;
    return this.http.put(this.todosUrl+'toggleCompleted', todo, httpOptions);
  }
}
