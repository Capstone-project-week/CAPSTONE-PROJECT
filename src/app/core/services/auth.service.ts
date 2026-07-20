import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, firstValueFrom } from 'rxjs';
import { tap } from 'rxjs/operators';

export interface User {
  uid: string;
  email: string | null;
  displayName: string | null;
  token?: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSubject = new BehaviorSubject<User | null>(null);
  public currentUser$: Observable<User | null> = this.currentUserSubject.asObservable();
  private authStateResolved = false;

  constructor(private http: HttpClient) {
    this.checkLocalStorage();
  }

  private checkLocalStorage() {
    const userJson = localStorage.getItem('currentUser');
    if (userJson) {
      this.currentUserSubject.next(JSON.parse(userJson));
    }
    this.authStateResolved = true;
  }

  public waitForAuthResolved(): Promise<void> {
    return new Promise((resolve) => {
      if (this.authStateResolved) {
        resolve();
      } else {
        const interval = setInterval(() => {
          if (this.authStateResolved) {
            clearInterval(interval);
            resolve();
          }
        }, 50);
      }
    });
  }

  public get currentUser(): User | null {
    return this.currentUserSubject.value;
  }

  public async register(email: string, password: string, displayName?: string) {
    const response = await firstValueFrom(
      this.http.post<any>('/api/v1/register', { email, password, username: displayName })
    );
    return this.handleAuthResponse(response);
  }

  public async login(email: string, password: string) {
    const response = await firstValueFrom(
      this.http.post<any>('/api/v1/login', { email, password })
    );
    return this.handleAuthResponse(response);
  }

  private handleAuthResponse(response: any): User {
    const user: User = {
      uid: String(response.id),
      email: response.email,
      displayName: response.username,
      token: response.token
    };
    localStorage.setItem('currentUser', JSON.stringify(user));
    this.currentUserSubject.next(user);
    return user;
  }

  public async logout() {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}
