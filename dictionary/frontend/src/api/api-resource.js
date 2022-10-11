import axios from 'axios' 

export const api = new axios.create({
	baseURL: process.env.BACKEND_URL,
	withCredentials: true
})