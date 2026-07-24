import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, of } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

export interface AiResponse {
  text: string;
}

@Injectable({
  providedIn: 'root'
})
export class AiGeneratorService {
  
  private readonly apiUrl = '/api/v1/stories/chat';

  constructor(private http: HttpClient) { }

  generateStory(prompt: string): Observable<AiResponse> {
    const payload = { 
      storyId: "story003", 
      playerId: "player001",
      userPrompt: prompt 
    };

    return this.http.post<any>(this.apiUrl, payload).pipe(
      map(response => {
        let text = 'No response generated.';
        if (response && response.output) {
          text = response.output;
        } else if (response && response.text) {
          text = response.text;
        } else if (typeof response === 'string') {
          text = response;
        }
        return { text };
      }),
      catchError(error => {
        console.error('AI Generation Error:', error);
        return of({ text: `Sorry, the n8n Agent returned an error or is unreachable.` });
      })
    );
  }
}
