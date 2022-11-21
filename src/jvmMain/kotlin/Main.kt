import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toPainter
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import javax.imageio.ImageIO

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    var addressInfo by remember { mutableStateOf("") }

    MaterialTheme {
        Scaffold {
            Row(
                modifier = Modifier.fillMaxHeight().fillMaxWidth()
                    .background(Color.White)
            ) {
                // 切换模式
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxHeight().width(150.dp)
                        .background(Color(247, 242, 243))
                ) {
                    Button(
                        onClick = {
                            addressInfo = "127.0.0.1:8000"
                        },
                        modifier = Modifier.padding(
                            top = 30.dp,
                            start = 10.dp
                        ).sizeIn(maxHeight = 120.dp, maxWidth = 120.dp)
                    ) {
                        Text(text = "TCP服务端")
                    }

                    Button(
                        onClick = {
                            addressInfo = "127.0.0.1:8000"
                        },
                        modifier = Modifier.padding(
                            top = 30.dp,
                            start = 10.dp
                        ).sizeIn(maxHeight = 120.dp, maxWidth = 120.dp)
                    ) {
                        Text(text = "TCP客户端")
                    }

                    Button(
                        onClick = { addressInfo = "127.0.0.1:8000" },
                        modifier = Modifier.padding(
                            top = 30.dp,
                            start = 10.dp
                        ).sizeIn(maxHeight = 120.dp, maxWidth = 120.dp)
                    ) {
                        Text(text = "UDP服务端")
                    }

                    Button(
                        onClick = { addressInfo = "127.0.0.1:8000" },
                        modifier = Modifier.padding(
                            top = 30.dp,
                            start = 10.dp
                        ).sizeIn(maxHeight = 120.dp, maxWidth = 120.dp)
                    ) {
                        Text(text = "UDP客户端")
                    }
                }

                // 输入框
                Row(
                    modifier = Modifier.width(650.dp)
                        .height(250.dp)
                        .background(Color.White)
                        .padding(start = 10.dp)
                ) {
                    TextField(
                        value = addressInfo,
                        onValueChange = {
                            addressInfo = it
                        },
                        modifier = Modifier.width(400.dp)
                            .height(70.dp)
                            .padding(start = 10.dp, top = 10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = Color.Gray,
                            backgroundColor = Color(247, 242, 243, 100),
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        ),

                        )
                }
            }
            // 消息框
        }


//            Row {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier.fillMaxHeight().width(120.dp)
//                        .background(Color(247, 242, 243))
//                ) {
//                    Button(
//                        onClick = {},
//                        modifier = Modifier.padding(
//                            top = 30.dp,
//                            start = 0.dp
//                        ).sizeIn(maxHeight = 120.dp, maxWidth = 120.dp)
//                    ) {
//
//                        Text(text = "TCP服务端")
//                    }
//                }
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier.fillMaxHeight()
//                        .background(Color.White)
//                ) {
//                    TextField(
//                        value = inputText, onValueChange = {
//                            inputText = it
//                        }, modifier = Modifier.height(226.dp).fillMaxWidth(),
//                        colors = TextFieldDefaults.textFieldColors(
//                            cursorColor = Color.Gray,
//                            backgroundColor = Color(247, 242, 243, 100),
//                            unfocusedIndicatorColor = Color.Transparent,
//                            focusedIndicatorColor = Color.Transparent,
//                        )
//                    )
//                }
//            }
    }

}


fun main() = application {

//    val resource = Any::class.java.getResource()
    Window(
        onCloseRequest = ::exitApplication,
        resizable = true,
        state = WindowState(size = DpSize(800.dp, 500.dp)),
        icon = useResource("icon.png") { fis ->
            ImageIO.read(fis).toPainter()
        }
    ) {
        this.window.title = "SocketTool"
        App()
    }
}
