import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { ResumeFormData } from '../resume-preview';

//import * as jspdf from 'jspdf';
import {jspdf} from 'jspdf';

import html2canvas from 'html2canvas';


@Component({
  selector: 'app-resume-preview',
  templateUrl: './resume-preview.component.html',
  styleUrls: ['./resume-preview.component.css']
})
export class ResumePreviewComponent implements OnInit {

  resumeFormdata: ResumeFormData;
  pdfFileName: string;
  employeeRole: string;



  constructor() {
    this.resumeFormdata = JSON.parse(localStorage.getItem('resume-data'));
    this.employeeRole = `Java Developer`;
    this.pdfFileName = `TestYantra_` + this.resumeFormdata.firstName + ` ` + this.resumeFormdata.lastName + `_` + this.employeeRole + `_` + this.resumeFormdata.totalExperience + ` Yrs`;

    // TestYantra_Harendra Kumar_Java Developer_5.5 Yrs
  }

  ngOnInit() {
  }

  public generatePDF() {
    var data = document.getElementById('contentToConvert');
    html2canvas(data).then(canvas => {
      // Few necessary setting options 
      var imgWidth = 208;
      var pageHeight = 295;
      var imgHeight = canvas.height * imgWidth / canvas.width;
      var heightLeft = imgHeight;

      const contentDataURL = canvas.toDataURL('image/jpg')
      let pdf = new jspdf('p', 'mm', 'a4'); // A4 size page of PDF 
      var position = 0;
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight);
      pdf.save(`${this.pdfFileName}.pdf`); // Generated PDF  
    });

  }

  // @ViewChild('content', {static: false}) content: ElementRef;

  // public generatePDF() {
  //   const doc = new jspdf();

  //   const specialElementHandlers = {
  //     '#editor': function (element, renderer) {
  //       return true;
  //     }
  //   };

  //   const content = this.content.nativeElement;

  //   doc.fromHTML(document.getElementById('content').innerHTML, 15, 15, {
  //     width: 190,
  //     'elementHandlers': specialElementHandlers
  //   });

  //   doc.save('test.pdf');
  // }
}
