# Setup steps

## Getting started

### Prerequisites

As database, we are going to use `MongoDB`. Therefore, it is necessary to have this database installed and running.

In the following page you can find a guide on how to install and start MongoDB depending on the operating system ([Install MongoDB](https://www.mongodb.com/docs/manual/installation/)).

As IDE we are going to use `Intellij IDEA Ultimate` (2020.3.2), where we will work with `Spring Boot` as framework and `JDK` 17.

### Open project and prepare IDE

In order to use and run the application, you first need to clone the repository.

```
git clone https://github.com/IreneSanxx/backend-test.git
```

Once you have cloned it, open the `Intellij IDEA`, go to `Projects` section, click on `Open` button and choose the folder of our project: `backend-test`.

As mentioned before, we are going to work with a MongoDB database. So we have to connect from Intellij to MongoDB. We are going to use the local MongoDB connection, which has as hostname *localhost* and as port *27017*.

For the connection, you can do this through one of the following options:

- From the main menu, navigate to File | New | Data Source and select MongoDB.

- In the Database tool window ( View | Tool Windows | Database), click the New icon (+) in the toolbar. Navigate to Data Source and select MongoDB.

Then, a tab will open where you can configure the connection to the database. By default, the standard local connection will be shown, with *localhost* as hostname and *27017* as port. So, just click on the `Apply` button, then `OK` and the connection will be ready.

The rest of the configuration for the database connection is prepared inside the `application.properties` file.

Finally, you just need to click on the `Run` button (which appears on the right side of the navigation bar, in green color) and the application is ready to use.

## Testing

To test the application, we have used `Postman`.

The file `testing.postman_collection.json` is a Postman collection which includes tests for creating, reading, updating and deleting users. You can import it into Postman and run the tests ([Import data into Postman](https://learning.postman.com/docs/getting-started/importing-and-exporting/importing-data/)).

These tests must be performed while the application is running.

You can install Postman from the following link ([Installing and updating Postman](https://learning.postman.com/docs/getting-started/installation/installation-and-updates/)).
