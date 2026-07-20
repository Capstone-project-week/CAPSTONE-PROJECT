import { NgModule } from '@angular/core';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './interceptors/auth.interceptor';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared/shared.module';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { CreatorLayoutComponent } from './layouts/creator-layout/creator-layout.component';
import { ReaderLayoutComponent } from './layouts/reader-layout/reader-layout.component';



@NgModule({
  declarations: [
    AuthLayoutComponent,
    AdminLayoutComponent,
    CreatorLayoutComponent,
    ReaderLayoutComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    SharedModule
  ],
  exports: [
    AuthLayoutComponent,
    AdminLayoutComponent,
    CreatorLayoutComponent,
    ReaderLayoutComponent
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ]
})
export class CoreModule { }
