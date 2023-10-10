import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HenkiloService } from '../../services/henkilo.service';

@Component({
  selector: 'app-henkilo-form',
  templateUrl: './henkilo-form.component.html',
  styleUrls: ['./henkilo-form.component.scss']
})
export class HenkiloFormComponent implements OnInit {
  myForm: FormGroup;
  initFormValues: any;
  henkiloList: any[] = [];
  editMode = false;
  editForm: FormGroup;

  constructor(private fb: FormBuilder, private henkiloService: HenkiloService) {
    this.myForm = this.fb.group({
      nimi: ['', Validators.required],
      henkilotunnus: [''],
      osoitetiedot: [''],
      kansalaisuus: [''],
      aidinkieli: [''],
      perhesuhdetiedot: [''],
      syntymaJaKuolintiedot: ['']
    });
    this.editForm = this.fb.group({
      id: [],
      nimi: ['', Validators.required],
      henkilotunnus: [''],
      osoitetiedot: [''],
      kansalaisuus: [''],
      aidinkieli: [''],
      perhesuhdetiedot: [''],
      syntymaJaKuolintiedot: ['']
    });
  }

  ngOnInit(): void {
    this.initFormValues = this.myForm.value;
    this.loadHenkilos();
  }

  loadHenkilos() {
    this.henkiloService.getHenkilo().subscribe({
      next: (response) => {
        this.henkiloList = response;
      },
      error: (error) => {
        console.error('Error fetching HenkiloList:', error);
      }
    });
  }

  onSubmit() {
    const formData = this.myForm.value;
    this.henkiloService.createHenkilo(formData).subscribe({
      next: (response) => {

        console.log('Henkilo created successfully:', response);
        this.loadHenkilos();

        this.myForm.reset(this.initFormValues);
      },
      error: (error) => {
        console.error('Error creating Henkilo:', error);
      }
    });
  }

  deleteHenkiloById(id: number) {
    this.henkiloService.deleteHenkilo(id).subscribe(
      () => {
        console.log('Henkilo deleted successfully');
        this.loadHenkilos();
      },
      (error) => {
        console.error('Error deleting Henkilo:', error);
      }
    );
  }

  startEdit(henkilo: any) {
    this.editMode = true;
    this.editForm.patchValue(henkilo);
  }

  cancelEdit() {
    this.editMode = false;
    this.editForm.reset();
  }

  onEditSubmit() {
    if (this.editForm.valid) {
      const formData = this.editForm.value;
      const idToUpdate = formData.id;
      this.henkiloService.updateHenkilo(idToUpdate, formData).subscribe({
        next: (response) => {
          console.log('Henkilo updated successfully:', response);
          this.editMode = false;
          this.editForm.reset();
          this.loadHenkilos();
        },
        error: (error) => {
          console.error('Error updating Henkilo:', error);
        }
      });
    }
  }

}