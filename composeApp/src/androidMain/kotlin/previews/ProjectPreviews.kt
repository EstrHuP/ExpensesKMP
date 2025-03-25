package previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estrhup.expenseskmp.ui.AllExpensesHeader
import com.estrhup.expenseskmp.ui.ExpensesTotalHeader

@Preview(showBackground = true)
@Composable
fun ExpensesTotalHeaderPreview() {
    Box(Modifier.padding(16.dp)) {
        ExpensesTotalHeader(1028.9)
    }
}

@Preview(showBackground = true)
@Composable
fun AllExpensesHeaderPreview() {
    Box(Modifier.padding(16.dp)) {
        AllExpensesHeader()
    }
}