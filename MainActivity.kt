package com.example.portfolio

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortfolioTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PortfolioApp()
                }
            }
        }
    }
}

@Composable
fun PortfolioApp(){
    Portfolio(
        logo = painterResource(R.drawable.logo),
        backgroundImage = painterResource(id = R.drawable.backgroung),
        name = stringResource(id = R.string.name),
        position = stringResource(id = R.string.position),
        phoneNumber = stringResource(id = R.string.phoneNumber),
        mail = painterResource(id = R.drawable.mail),
        email = stringResource(id = R.string.email),
        emailIcon = painterResource(id = R.drawable.mail),
        socialIcon = painterResource(id = R.drawable.share),
        social = stringResource(id = R.string.social),


    )
}

@Composable
private fun Portfolio(
    logo: Painter,
    backgroundImage: Painter,
    modifier: Modifier = Modifier,
    name: String,
    position: String,
    phoneNumber: String,
    mail: Painter,
    email: String,
    emailIcon: Painter,
    socialIcon: Painter,
    social: String,
) {
    // 1. A SINGLE ROOT BOX FOR THE ENTIRE SCREEN
    // The modifier from the function signature is applied here.
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // 2. THE BACKGROUND IMAGE
        // This is the bottom layer of the Box.
        Image(
            painter = backgroundImage,
            contentScale = ContentScale.Crop,
            alpha = 0.4F,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        // 3. THE CENTERED CONTENT
        // This Column is aligned to the center of the root Box.
        Column(
            modifier = Modifier
                .align(Alignment.Center) // Align this element within the parent Box
                .background(
                    color = Color(0xFF87CEEB),
                    shape = MaterialTheme.shapes.extraSmall
                )
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = logo,
                contentDescription = null,
            )
            Text(
                text = name,
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 30.sp,
                modifier = Modifier
            )
            Text(
                text = position,
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }

        // 4. THE BOTTOM CONTACT INFORMATION
        // This Column is aligned to the bottom-center of the root Box.
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Align this element within the parent Box
                .padding(bottom = 32.dp), // Add some padding from the screen edge
            horizontalAlignment = Alignment.CenterHorizontally // Align rows to the start for a clean look
        ) {
            // Row for Phone Number
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp) // Space between rows
            ) {
                Image(
                    painter = mail, // You have a 'mail' painter for the phone
                    contentDescription = null,
                )
                Text(
                    text = phoneNumber,
                    style = MaterialTheme.typography.bodyLarge, // Adjusted style for clarity
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp) // Increased padding
                )
            }
            // Row for Email
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp) // Space between rows
            ) {
                Image(
                    painter = emailIcon,
                    contentDescription = null,
                )
                Text(
                    text = email,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            // Row for Social
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = socialIcon,
                    contentDescription = null,
                )
                Text(
                    text = social,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp) // FIX: Added modifier
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PortfolioTheme {
        PortfolioApp()
    }
}