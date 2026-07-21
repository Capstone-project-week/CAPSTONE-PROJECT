import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StoryService } from '../../../core/services/story.service';

@Component({
  selector: 'app-generator-flow',
  templateUrl: './generator-flow.component.html',
  styleUrls: ['./generator-flow.component.scss']
})
export class GeneratorFlowComponent {
  currentStep = 1;
  isGenerating = false;
  activeEngine: string = 'squibler';
  promptInput: string = '';

  constructor(private router: Router, private storyService: StoryService) {}

  selectEngine(engine: string) {
    this.activeEngine = engine;
  }

  nextStep() {
    if (this.currentStep < 5) {
      this.currentStep++;
    }
  }

  prevStep() {
    if (this.currentStep > 1) {
      this.currentStep--;
    }
  }

  simulateGeneration() {
    this.isGenerating = true;
    setTimeout(() => {
      this.isGenerating = false;
      this.nextStep();
    }, 1500);
  }

  publishGeneratedStory() {
    this.isGenerating = true;
    this.storyService.createStory({
      title: 'AI Generated Story',
      prompt: this.promptInput || 'A random creative story',
      content: '' // Backend will use AI to fill this if empty
    }).subscribe({
      next: (res) => {
        this.isGenerating = false;
        alert('Story generated and published successfully!');
        this.router.navigate(['/stories']);
      },
      error: (err) => {
        this.isGenerating = false;
        alert('Failed to publish story.');
        console.error(err);
      }
    });
  }
}
