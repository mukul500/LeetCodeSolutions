package graphs

class FloodFill {

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {

        //We Check if the color is the same as the new color
        if (image[sr][sc] == color) {
            return image
        } else {
            //If the color is not the same as the new color, we call the dfs method
            dfs(image, sr, sc, image[sr][sc], color)
        }
        return image
    }

    fun dfs(image: Array<IntArray>, sr: Int, sc: Int, color: Int, newColor: Int) {


        //We check if the row and column are within the bounds of the image and if the color is the same as the original color
        if (sr < 0 || sr >= image.size || sc < 0 || sc >= image[0].size || image[sr][sc] != color) {
            return
        } else {

            //If the color is the same as the original color, we update the color to the new color
            image[sr][sc] = newColor
            //We call the dfs method on the top, bottom, left and right cells
            dfs(image, sr - 1, sc, color, newColor)
            dfs(image, sr + 1, sc, color, newColor)
            dfs(image, sr, sc - 1, color, newColor)
            dfs(image, sr, sc + 1, color, newColor)
        }
    }

}


class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        if (image[sr][sc] == color) {
            return image
        } else {
            //If the color is not the same as the new color, we call the dfs method
            dfs(image, sr, sc, image[sr][sc], color)
        }
        return image

    }

    fun dfs(image: Array<IntArray>, row: Int, col: Int, oldColor: Int, newColor: Int) {
        if (!isValidIndex(image, row, col)) return
        else if (image[row][col] == newColor) return
        if (image[row][col] == oldColor) {
            image[row][col] = newColor
            dfs(image, row + 1, col, oldColor, newColor)
            dfs(image, row - 1, col, oldColor, newColor)
            dfs(image, row, col + 1, oldColor, newColor)
            dfs(image, row, col - 1, oldColor, newColor)
        }

    }

    private fun isValidIndex(image: Array<IntArray>, row: Int, col: Int): Boolean {
        return (row >= 0 && row < image.size) && (col >= 0 && col < image[0].size)
    }


}