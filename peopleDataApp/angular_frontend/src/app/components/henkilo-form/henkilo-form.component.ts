import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-henkilo-form',
  templateUrl: './henkilo-form.component.html',
  styleUrls: ['./henkilo-form.component.scss']
})
export class HenkiloFormComponent implements OnInit {
  myForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.myForm = this.fb.group({
      nimi: ['', Validators.required],
    });
  }
  initFormValues: any;

  ngOnInit(): void {
    this.myForm = this.fb.group({
      nimi: ['', Validators.required],
      henkilotunnus: ['', Validators.required],
      osoitetiedot: [''],
      kansalaisuus: [''],
      aidinkieli: [''],
      perhesuhdetiedot: [''],
      syntymaJaKuolinTiedot: ['']
    });

    this.initFormValues = this.myForm.value;
  }

  onSubmit() {
    const formData = this.myForm.value;
    console.log(formData);

    this.myForm.setValue(this.initFormValues);
  }
}
