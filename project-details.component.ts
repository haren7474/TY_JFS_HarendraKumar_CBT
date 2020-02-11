import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, NgForm, Validators, FormControl, FormArray } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css']
})
export class ProjectDetailsComponent implements OnInit {

  projectDetailsForm: FormGroup;

  constructor(private fb: FormBuilder,
    private router: Router) {
  }

  ngOnInit() {
    this.projectDetailsForm = new FormGroup({


      projects: new FormArray([
        this.getProject()
      ]),

      summaries: new FormArray([
        this.getSummary()
      ])
      
    });
  }

  getProject(): FormControl {
    return new FormControl(null, [Validators.required, Validators.minLength(10)]);
  }

  addProject() {
    this.projects.push(this.getProject());
  }

  deleteProject(i: number) {
    this.projects.removeAt(i);
  }

  get projects(): FormArray {
    return this.projectDetailsForm.get('projects') as FormArray;
  }


  // called after submitting the form
  resumePreview() {
    console.log(this.projectDetailsForm.value);
    // localStorage.setItem('resume-data', JSON.stringify(this.projectDetailsForm.value));
    // let formValue = JSON.parse(localStorage.getItem('resume-data'))
    // console.log(formValue.buildAutomationTool);
    // console.log(formValue.summaries);
    // this.router.navigateByUrl('projectDetails');
  }



  // to have new form control object
  getSummary(): FormControl {
    return new FormControl(null, [Validators.required, Validators.minLength(20)]);
  }


  // to push form control in forarray
  addSummary() {
    this.summaries.push(this.getSummary());
  }

 

  // to delete each summary
  deleteSummary(i: number) {
    this.summaries.removeAt(i);
  }

  

  get summaries(): FormArray {
    return this.projectDetailsForm.get('summaries') as FormArray;
  }

}
