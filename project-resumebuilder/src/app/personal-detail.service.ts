import { Injectable } from '@angular/core';
import { PersonalDetail } from './personal-detail';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './users';
import { userInfo } from 'os';


@Injectable({
  providedIn: 'root'
})
export class PersonalDetailService {

  selectedPersonalDetailToUpdate: PersonalDetail;

  api = 'http://localhost:8080/resumebuilder';
  user: User;

  constructor(private http: HttpClient) { }

  postData(personalDetail: PersonalDetail): Observable<any> {
    // let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    // this.user = new User();
    // this.user.userId = userDetails.userBean[0].userId;
    // personalDetail.userBean = this.user;
    return this.http.post<any>(`${this.api}/addPersonalDetail`, personalDetail);
  }

  deleteData(personalDetail): Observable<any> {
    return this.http.delete<any>(`${this.api}/deletePersonalDetail/${personalDetail.personalDetailId}`);
  }

  updateData(personalDetail): Observable<any> {
    return this.http.put<any>(
      `${this.api}/updatePersonalDetail`, personalDetail);
  }
}
