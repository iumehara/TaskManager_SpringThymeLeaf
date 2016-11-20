#Task Manager

## Database Setup
- Create Postgresql database
    - `createdb taskManager_dev`

- Run migration file in psql
    - `psql taskManager_dev`
    - `\i ~/path/to/project/TaskManager/src/main/resources/db/migrations.sql`

- Load CSV Data file in psql
    - `psql taskManager_dev`
    - `\i ~/path/to/project/TaskManager/src/main/resources/db/loadCsv.sql`
