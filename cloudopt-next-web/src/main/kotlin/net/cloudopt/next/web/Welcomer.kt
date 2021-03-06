/*
 * Copyright 2017-2021 Cloudopt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.cloudopt.next.web

import net.cloudopt.next.logging.Logger
import java.io.BufferedReader
import java.io.InputStreamReader


/*
 * @author: Cloudopt
 * @Time: 2020/3/13
 * @Description: Welcome Tool
 */
object Welcomer {

    private val logger = Logger.getLogger(NextServer::class)

    @JvmStatic
    fun html(fileName: String): String {

        var input = Welcomer.javaClass.classLoader.getResourceAsStream(fileName)

        var buffer = BufferedReader(InputStreamReader(input))

        var line = buffer.readLine()

        var welcomeHtml = ""

        while (line != null) {
            welcomeHtml += line
            line = buffer.readLine()
        }

        buffer.close()

        return welcomeHtml

    }

    @JvmStatic
    fun home(): String {
        return html("welcome.html")
    }

    @JvmStatic
    fun notFound(): String {
        return html("404.html")
    }

    @JvmStatic
    fun systemError(): String {
        return html("500.html")
    }

}