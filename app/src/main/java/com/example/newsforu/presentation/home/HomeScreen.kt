package com.example.newsforu.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.paging.compose.LazyPagingItems
import com.example.newsforu.domain.model.Article
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsforu.R
import com.example.newsforu.presentation.common.ArticlesList
import com.example.newsforu.presentation.common.SearchBar
import com.example.newsforu.presentation.common.SearchBarPreview
import com.example.newsforu.presentation.nvgraph.Route
import com.example.newsforu.presentation.onboarding.Dimens.MediumPadding1
import com.example.newsforu.presentation.onboarding.Dimens.MediumPadding2

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
        articles: LazyPagingItems<Article>,
        navigateToSearch:()-> Unit,
        navigateToDetails:(Article)-> Unit
){
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount> 10){
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = "\uD83d\uDFE5 "){it.title}
            }else{
                " "
            }
        }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ){
        Image(painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = MediumPadding2)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        SearchBar(
            modifier = Modifier.padding(MediumPadding1),
            text = "",
            readOnly = true,
            onValueChange = {},
            onClick = {
                navigateToSearch()
            },
            onSearch = {}
        )

        Spacer(modifier = Modifier.height(MediumPadding1))
        
        Text(
            text = titles,
            modifier  = Modifier
                .fillMaxWidth()
                .padding(start = MediumPadding1)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder) 
        )
        
        Spacer(modifier = Modifier.height(MediumPadding1))
        
        ArticlesList(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            articles = articles,
            onClick = {
                navigateToDetails(it)
            }
        )

    }

}