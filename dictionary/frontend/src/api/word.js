import { api } from '@/api/api-resource'

export default {
	create: word => api.post('words/create', {word}),
	update: word => api.post('words/update', {word}),
	list: () => api.get('words'),
	get: id => api.get('words', {params: { id }})
}