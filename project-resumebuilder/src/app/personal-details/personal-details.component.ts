import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl, FormArray, NgForm } from '@angular/forms';
import { PersonalDetailService } from '../personal-detail.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-personal-details',
  templateUrl: './personal-details.component.html',
  styleUrls: ['./personal-details.component.css']
})
export class PersonalDetailsComponent implements OnInit {

  registerForm: FormGroup;
  message: string;
  error: string;
  statusCode: number;
  currentUserId: number;

  constructor(private fb: FormBuilder, private pdService: PersonalDetailService, private router: Router) {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    this.currentUserId= userDetails.userBean[0].userId;
  }

  addPersonal(registerForm: NgForm) {
    console.log(this.registerForm.value);
    this.pdService.postData(registerForm.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.description;
      } else if (res.statusCode === 401) {
        this.error = res.description;
        setTimeout(() => {
          this.message = null;
          this.error = null;
        }, 5000);
      }
    });
  }

  deleteMessage() {
    this.message = null;
    this.statusCode = null;
    this.router.navigateByUrl('/');
  }

  ngOnInit() {
    this.registerForm = new FormGroup({

      firstName: this.fb.control(null,
        [Validators.required, Validators.minLength(3),
        Validators.pattern('([a-zA-Z]{3,20})')]),

      middleName: this.fb.control(null,
        [Validators.required, Validators.minLength(3),
        Validators.pattern('([a-zA-Z]{3,20})')]),

      lastName: this.fb.control(null,
        [Validators.required, Validators.minLength(3),
        Validators.pattern('([a-zA-Z]{3,20})')]),

      graduationDegree: this.fb.control(null,
        [Validators.required, Validators.minLength(2),
        Validators.pattern('([a-zA-Z. ]{2,20})')]),

      degreeBranch: this.fb.control(null,
        [Validators.required, Validators.minLength(2),
        Validators.pattern('([a-zA-Z. ]{2,20})')]),

      totalExperience: this.fb.control(null,
        [Validators.required, Validators.pattern('([0-9]|[1-4][0-9]|50)')]),

      relaventExperience: this.fb.control(null,
        [Validators.required, Validators.pattern('([0-9]|[1-4][0-9]|50)')]),

      mobileNumber: this.fb.control(null,
        [Validators.required,
        Validators.pattern('[7-9]{1}[0-9]{9}')]),
      
        userBean: this.fb.group({
        userId: this.fb.control(this.currentUserId),

      })
    });
  }

  get firstName() {
    return this.registerForm.get('firstName');
  }

  get middleName() {
    return this.registerForm.get('middleName');
  }

  get lastName() {
    return this.registerForm.get('lastName');
  }

  get graduationDegree() {
    return this.registerForm.get('graduationDegree');
  }

  get degreeBranch() {
    return this.registerForm.get('degreeBranch');
  }

  get totalExperience() {
    return this.registerForm.get('totalExperience');
  }

  get relaventExperience() {
    return this.registerForm.get('relaventExperience');
  }

  get mobileNumber() {
    return this.registerForm.get('mobileNumber');
  } 
}
