package com.example.mealzapp.ui.details
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.SemanticsProperties.ContentDescription
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.model.response.MealResponse
import kotlin.math.sin
import androidx.compose.foundation.Image as Image


@Composable
fun MealDetailsScreen(meal: MealResponse){
    /*
    var profilepictureState by remember{ mutableStateOf(MealProfilepictureState.Normal)}
    val transition = updateTransition(targetState = profilepictureState,label="")
    val imageSizeDp by transition.animateDp(targetValueByState = { it.size }, label = "")
    val color by transition.animateColor(targetValueByState = {it.color},label="")
    val widthSize by transition.animateDp(targetValueByState = {it.borderWidth},label="")

    */
    val scrollState = rememberLazyListState()
    val offset = sin(1f,1-(ScrollState.firstVisibleItemScrollOffset / 600f + scrollState.firstVisibleItemIndex))
//    val offset = sin( a= 1f, b= 1-(scrollState.value/600f) )
    val size by animateDpAsState(targetValue = max(100.dp , 200.dp  + offset) )

    Surface(MaterialTheme.colors.background) {

        Column {
            Surface(elevation = 4.dp) {

                Row {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            2.dp,
                            color = Color.Green
                        )
                    ) {

                        Image(
                            painter = rememberImagePainter(
                            data = meal?.imageUrl,
                            builder = {
                                transformations(CircleCropTransformation())
                            }),
                            ContentDescription = null,
                            modifier = Modifier
                                .size(max(100.dp , 200.dp+offset))
                        )
                    }
                    Text(
                        meal?.name ?: "default name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
                /*Button(modifier = Modifier.padding(16.dp),
                onClick = {
                    profilepictureState = if (profilepictureState == MealProfilepictureState.Normal)
                        MealProfilepictureState.Expanded
                    else
                        MealProfilepictureState.Normal
                }) {
                Text("Change state of meal profile picture")
            }
*/

                Column(modifier = Modifier.verticalScroll(scrollState)) {
                    Text(text = "this is yoyo", modifier = Modifier.padding(32.dp))
                    Text(text = "this is yoyo", modifier = Modifier.padding(32.dp))
                    Text(text = "this is yoyo", modifier = Modifier.padding(32.dp))
                    Text(text = "this is yoyo", modifier = Modifier.padding(32.dp))
                    Text(text = "this is yoyo", modifier = Modifier.padding(32.dp))
                    Text(text = "this is yoyo", modifier = Modifier.padding(32.dp))
                    Text(text = "this is yoyo", modifier = Modifier.padding(32.dp))
                    Text(text = "this is yoyo", modifier = Modifier.padding(32.dp))

                }
            }

        }
        val dummyContentList =(0..100).map {it.toString()}
        LazyColumn(state = scrollState) {
            items(dummyContentList){ dummyItems ->
                Text(text = dummyItems,modifier = Modifier.padding(24.dp))
            }

        }
    }

}

enum class MealProfilepictureState(val color: Color, val size: Dp , val borderWidth: Dp){
    Normal(Color.Magenta,120.dp,8.dp),
    Expanded(Color.Green , 200.dp , 24.dp)
}