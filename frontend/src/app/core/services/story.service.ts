import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface StoryDto {
  id?: number;
  title: string;
  prompt: string;
  content: string;
  createdAt?: string;
  userId?: number;
}

@Injectable({
  providedIn: 'root'
})
export class StoryService {
  constructor(private http: HttpClient) {}

  getUserStories(): Observable<StoryDto[]> {
    return this.http.get<StoryDto[]>('/api/v1/stories');
  }

  createStory(story: StoryDto): Observable<StoryDto> {
    return this.http.post<StoryDto>('/api/v1/stories', story);
  }
}
