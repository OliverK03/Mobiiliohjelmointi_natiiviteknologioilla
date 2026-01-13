package com.example.week1.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.week1.domain.*
import java.time.LocalDate

@Composable
fun HomeScreen() {

    var allTasks by remember { mutableStateOf(mockTasks) }
    var sortAscending by remember { mutableStateOf(true)}
    var tasks by remember { mutableStateOf(mockTasks) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text = "Task-lista (week1)",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

                Button(onClick = {
                    tasks = if (sortAscending) {
                        sortByDueDate(tasks)
                    } else {
                        sortByDueDate(tasks).reversed()
                    }
                    sortAscending = !sortAscending
                },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        if (sortAscending)
                            "Järjestä laskevasti"
                        else
                            "Järjestä nousevasti"
                    )
                }


                Button(onClick = {
                    tasks = filterByDone(allTasks, true)
                }) {
                    Text("Näytä valmiit")
                }

                Button(onClick = {
                    tasks = allTasks
                }) {
                    Text("Näytä kaikki")
                }
            }

            Spacer(Modifier.height(16.dp))

            Button(onClick = {
                val newTask = Task(
                    id = tasks.size + 1L,
                    title = "Uusi tehtävä",
                    description = "Lisätty napista",
                    priority = TaskPriority.LOW,
                    dueDate = LocalDate.now().plusDays(5),
                    done = false
                )
                allTasks = addTask(allTasks, newTask)
                tasks = allTasks
            }) {
                Text("Lisää tehtävä")
            }

            Spacer(Modifier.height(16.dp))

            tasks.forEach { task ->
                TaskRow(
                    task = task,
                    onToggleDone = { id ->
                        allTasks = toggleDone(allTasks, id)
                        tasks = allTasks
                    }
                )
            }
        }
    }
}

@Composable
fun TaskRow(task: Task, onToggleDone: (Long) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onToggleDone(task.id) }
    ) {
        Text(task.title, style = MaterialTheme.typography.titleMedium)
        Text(task.description, style = MaterialTheme.typography.bodyMedium)
        Text(
            "Eräpäivä: ${task.dueDate} | Prioriteetti: ${task.priority} | Valmis: ${task.done}",
            style = MaterialTheme.typography.bodySmall
        )
    }
}
