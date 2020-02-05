import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, NgForm, Validators, FormControl, FormArray } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-builder-form',
  templateUrl: './builder-form.component.html',
  styleUrls: ['./builder-form.component.css']
})
export class BuilderFormComponent implements OnInit {

  registerForm: FormGroup;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit() {
    this.registerForm = new FormGroup({

      firstName: this.fb.control(null,
        [Validators.required, Validators.minLength(3),
        Validators.pattern('([a-zA-Z]{3,20})')]),

      middleName: this.fb.control(null),

      lastName: this.fb.control(null,
        [Validators.required, Validators.minLength(3),
        Validators.pattern('([a-zA-Z]{1,20})')]),

      graduationDegree: this.fb.control(null,
        [Validators.required, Validators.minLength(2),
        Validators.pattern('([a-zA-Z. ]{2,30})')]),

      degreeBranch: this.fb.control(null,
        [Validators.required, Validators.minLength(2),
        Validators.pattern('([a-zA-Z. ]{2,30})')]),

      totalExperience: this.fb.control(null,
        [Validators.required, Validators.pattern('([0-9]|[1-4][0-9]|50)')]),

      relaventExperience: this.fb.control(null,
        [Validators.required,
        Validators.max(8),
        Validators.pattern('([0-9]|[1-4][0-9]|50)')]),

      languages: this.fb.control(null),

      javaEE: this.fb.control(null),

      frontEndFramework: this.fb.control(null),

      backEndFramework: this.fb.control(null),

      designPatterns: this.fb.control(null),

      rdbsApplications: this.fb.control(null),

      webServers: this.fb.control(null),

      aws: this.fb.control(null),

      codeQualityTools: this.fb.control(null),

      versionControlSystem: this.fb.control(null),

      buildAutomationTool: this.fb.control(null),

      cicdTool: this.fb.control(null),

      otherTools: this.fb.control(null),

      sdlc: this.fb.control(null),


      summaries: new FormArray([
        this.getSummary()
      ]),

      achievements: new FormArray([
        this.getAchievement()
      ])
    });
  }

  // to have new form control object
  getSummary(): FormControl {
    return new FormControl(null, [Validators.required, Validators.minLength(20)]);
  }

  getAchievement(): FormControl {
    return new FormControl(null, [Validators.required, Validators.minLength(10)]);
  }

  // to push form control in forarray
  addSummary() {
    this.summaries.push(this.getSummary());
  }

  addAchievement() {
    this.achievements.push(this.getAchievement());
  }

  // to delete each summary
  deleteSummary(i: number) {
    this.summaries.removeAt(i);
  }

  deleteAchievement(i: number) {
    this.achievements.removeAt(i);
  }

  get summaries(): FormArray {
    return this.registerForm.get('summaries') as FormArray;
  }

  get achievements(): FormArray {
    return this.registerForm.get('achievements') as FormArray;
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

  get languages() {
    return this.registerForm.get('languages');
  }

  get javaEE() {
    return this.registerForm.get('javaEE');
  }

  get backEndFramework() {
    return this.registerForm.get('backEndFramework');
  }

  get designPatterns() {
    return this.registerForm.get('designPatterns');
  }

  get rdbsApplications() {
    return this.registerForm.get('rdbsApplications');
  }
  get webServers() {
    return this.registerForm.get('webServers');
  }
  get aws() {
    return this.registerForm.get('aws');
  }
  get codeQualityTools() {
    return this.registerForm.get('codeQualityTools');
  }
  get versionControlSystem() {
    return this.registerForm.get('versionControlSystem');
  }
  get buildAutomationTool() {
    return this.registerForm.get('buildAutomationTool');
  }
  get cicdTool() {
    return this.registerForm.get('cicdTool');
  }
  get otherTools() {
    return this.registerForm.get('otherTools');
  }
  get sdlc() {
    return this.registerForm.get('sdlc');
  }


  // called after submitting the form
  submitForm() {
    //console.log(this.registerForm.value);
    localStorage.setItem('resume-data', JSON.stringify(this.registerForm.value));
    let formValue = JSON.parse(localStorage.getItem('resume-data'))
    console.log(formValue.buildAutomationTool);
    console.log(formValue.summaries);
  }
}
