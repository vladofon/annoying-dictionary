import axios from 'axios' 

export const HTTP = new axios.create({
	baseURL: 'http://localhost:8080/'
})