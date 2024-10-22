import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css'],
  standalone: true,
  imports: [FormsModule] // Include FormsModule here
})
export class ChatComponent {
  messages: { sender: string; content: string }[] = [];
  newMessage: string = '';

  sendMessage(): void {
    if (this.newMessage.trim()) {
      this.messages.push({ sender: 'You', content: this.newMessage });
      this.newMessage = ''; // Reset input
    }
  }
}
