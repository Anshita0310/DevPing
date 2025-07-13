# DevPing Frontend

A modern React.js frontend for the DevPing - Developer Connect Platform.

## Features

- 🎨 **Modern UI/UX** - Built with React and Tailwind CSS
- 🔐 **Authentication** - JWT-based authentication with login/register
- 📱 **Responsive Design** - Works on desktop, tablet, and mobile
- 🚀 **Real-time Updates** - Dynamic content updates
- 🌐 **API Integration** - Seamless integration with Spring Boot backend
- 🎯 **Project Management** - Create, manage, and collaborate on projects
- ✅ **Task Management** - Assign and track tasks with priorities
- 👥 **Developer Network** - Connect with other developers
- 🔧 **Profile Management** - Customizable user profiles
- ⚙️ **Settings** - Comprehensive user settings and preferences

## Tech Stack

- **Frontend**: React 18, React Router v6
- **Styling**: Tailwind CSS 3.2
- **HTTP Client**: Axios
- **Form Handling**: React Hook Form
- **State Management**: React Context API
- **Build Tool**: Create React App

## Project Structure

```
src/
├── components/          # Reusable UI components
│   ├── Navigation.js    # Main navigation component
│   └── PrivateRoute.js  # Route protection component
├── pages/               # Page components
│   ├── Login.js         # Login page
│   ├── Register.js      # Registration page
│   ├── Dashboard.js     # Dashboard page
│   ├── Projects.js      # Projects listing page
│   ├── Tasks.js         # Tasks management page
│   ├── Developers.js    # Developer network page
│   ├── Profile.js       # User profile page
│   └── Settings.js      # Settings page
├── services/            # API services
│   └── api.js          # API client configuration
├── context/             # React Context providers
│   └── AuthContext.js  # Authentication context
├── hooks/               # Custom React hooks
├── utils/               # Utility functions
├── App.js              # Main App component
├── index.js            # Entry point
└── index.css           # Global styles
```

## Getting Started

### Prerequisites

- Node.js 16.x or higher
- npm or yarn
- DevPing backend running on http://localhost:8080

### Installation

1. Clone the repository:
```bash
git clone <https://github.com/Anshita0310/DevPing.git>
cd devping-frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm start
```

The application will open in your browser at `http://localhost:3000`.

### Backend Configuration

The frontend is configured to proxy API requests to the backend running on `http://localhost:8080`. This is configured in the `package.json` file:

```json
{
  "proxy": "http://localhost:8080"
}
```

For production, you can set the `REACT_APP_API_URL` environment variable:

```bash
REACT_APP_API_URL=http://localhost:8080/api
```

## Features Overview

### Authentication
- User registration with comprehensive profile setup
- Secure login with JWT tokens
- Password validation and confirmation
- Protected routes for authenticated users

### Dashboard
- Welcome message and quick actions
- Recent activity overview
- Quick navigation to main features

### Projects
- Browse all available projects
- Create new projects with detailed information
- Join projects as a contributor
- View project details and contributors
- Filter and search projects

### Tasks
- View all tasks across projects
- Create and assign tasks
- Set task priorities (Low, Medium, High, Urgent)
- Update task status (TODO, In Progress, Done)
- Due date management

### Developer Network
- Browse registered developers
- View developer profiles and skills
- Contact developers via email
- Social media integration (GitHub, LinkedIn)
- Search and filter developers

### Profile Management
- Comprehensive user profiles
- Skills showcase
- Social media links
- Bio and personal information
- Project history

### Settings
- Account settings and preferences
- Notification preferences
- Security settings (password change)
- Data management (export/delete)

## API Integration

The frontend communicates with the Spring Boot backend through REST APIs:

### Authentication APIs
- `POST /api/auth/signin` - User login
- `POST /api/auth/signup` - User registration

### User APIs
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `PUT /api/users/{id}` - Update user profile

### Project APIs
- `GET /api/projects` - Get all projects
- `POST /api/projects` - Create new project
- `GET /api/projects/{id}` - Get project details
- `POST /api/projects/{id}/join` - Join project

### Task APIs
- `GET /api/tasks` - Get all tasks
- `POST /api/tasks` - Create new task
- `PUT /api/tasks/{id}` - Update task
- `GET /api/projects/{id}/tasks` - Get project tasks

## Styling

The application uses Tailwind CSS for styling with a custom design system:

### Color Scheme
- **Primary**: Blue shades for main actions and branding
- **Secondary**: Gray shades for secondary elements
- **Success**: Green for successful actions
- **Warning**: Yellow for warnings
- **Danger**: Red for errors and dangerous actions

### Components
- Custom button styles (`.btn`, `.btn-primary`, `.btn-secondary`)
- Input field styles (`.input`)
- Card components (`.card`, `.card-header`, `.card-body`)
- Badge components (`.badge` with color variants)

## Development

### Available Scripts

- `npm start` - Start development server
- `npm build` - Build for production
- `npm test` - Run tests
- `npm eject` - Eject from Create React App

### Adding New Features

1. Create new components in `src/components/`
2. Create new pages in `src/pages/`
3. Add API calls in `src/services/api.js`
4. Update routing in `src/App.js`
5. Add navigation links in `src/components/Navigation.js`

### Code Style

- Use functional components with hooks
- Use arrow functions for component definitions
- Use Tailwind CSS classes for styling
- Use lucide-react for icons
- Follow React best practices

## Testing

The project includes basic testing setup with Create React App. You can run tests with:

```bash
npm test
```

## Deployment

### Build for Production

```bash
npm run build
```

This creates an optimized build in the `build/` directory.

### Environment Variables

Create a `.env` file in the root directory:

```env
REACT_APP_API_URL=http://localhost:8080/api
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is licensed under the MIT License.
